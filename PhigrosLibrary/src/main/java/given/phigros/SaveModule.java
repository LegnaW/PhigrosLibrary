package given.phigros;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

abstract class MapSaveModule<T> extends LinkedHashMap<String, T> implements SaveModule {
    abstract void output(ByteWriter writer, T entry) throws IOException;

    abstract T input(ByteReader reader);

    @Override
    public SaveModule loadFromBinary(byte[] data) {
        clear();
        byte suffix = 0;
        if (this instanceof GameRecord)
            suffix = 2;
        ByteReader reader = new ByteReader(data);
        short len = reader.getVarshort();
        for (; len > 0; len--) {
            String key = reader.getString(suffix);
            short mark = reader.getByte();
            mark += reader.position;
            put(key, input(reader));
            reader.position = mark;
        }
        loadFromBinary(reader);
        return this;
    }

    @Override
    public byte[] serialize() throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ByteWriter writer = new ByteWriter(outputStream);
            writer.putVarshort((short) size());
            for (final Map.Entry<String, T> entry : entrySet()) {
                String key = entry.getKey();
                if (this instanceof GameRecord)
                    key += ".0";
                final byte[] strBytes = key.getBytes();
                writer.putByte(strBytes.length);
                writer.outputStream.write(strBytes);
                output(writer, entry.getValue());
            }
            serialize(writer);
            return outputStream.toByteArray();
        }
    }
}

public interface SaveModule {
    default SaveModule loadFromBinary(byte[] data) {
        ByteReader reader = new ByteReader(data);
        loadFromBinary(reader);
        return this;
    }
    default void loadFromBinary(ByteReader reader) {
        try {
            byte index = 0;
            Field[] fields = getClass().getFields();
            Arrays.sort(fields, Comparator.comparingInt(filed -> filed.getAnnotation(Order.class).value()));
            for (final Field field : fields) {
                System.out.println(field.toString());
                if (field.getType() == boolean.class) {
                    field.setBoolean(this, Util.getBit(reader.data[reader.position], index++));
                    continue;
                }
                if (index != 0) {
                    index = 0;
                    reader.position++;
                }
                if (field.getType() == String.class)
                    field.set(this, reader.getString(0));
                else if (field.getType() == float.class)
                    field.setFloat(this, reader.getFloat());
                else if (field.getType() == short.class)
                    field.setShort(this, reader.getShort());
                else if (field.getType() == short[].class) {
                    final short[] array = (short[]) field.get(this);
                    for (byte i = 0; i < array.length; i++)
                        array[i] = reader.getVarshort();
                } else if (field.getType() == byte.class)
                    field.setByte(this, reader.getByte());
                else throw new RuntimeException("出现新类型。");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    default byte[] serialize() throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ByteWriter writer = new ByteWriter(outputStream);
            serialize(writer);
            return outputStream.toByteArray();
        }
    }

    default void serialize(ByteWriter writer) throws IOException {
        try {
            byte b = 0;
            byte index = 0;
            Field[] fields = getClass().getFields();
            Arrays.sort(fields, Comparator.comparingInt(filed -> filed.getAnnotation(Order.class).value()));
            for (final Field field : fields) {
                if (field.getType() == boolean.class) {
                    b = Util.modifyBit(b, index++, field.getBoolean(this));
                    continue;
                }
                if (b != 0 && index != 0) {
                    writer.putByte(b);
                    b = index = 0;
                }
                if (field.getType() == String.class)
                    writer.putString((String) field.get(this));
                else if (field.getType() == float.class)
                    writer.putFloat(field.getFloat(this));
                else if (field.getType() == short.class)
                    writer.putShort(field.getShort(this));
                else if (field.getType() == short[].class)
                    for (final short h : (short[]) field.get(this))
                        writer.putVarshort(h);
                else if (field.getType() == byte.class)
                    writer.putByte(field.getByte(this));
                else
                    throw new RuntimeException("出现新类型。");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}