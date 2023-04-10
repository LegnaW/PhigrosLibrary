/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)", date = "2023-04-10")
public class SongExpect implements org.apache.thrift.TBase<SongExpect, SongExpect._Fields>, java.io.Serializable, Cloneable, Comparable<SongExpect> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SongExpect");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField LEVEL_FIELD_DESC = new org.apache.thrift.protocol.TField("level", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField ACC_FIELD_DESC = new org.apache.thrift.protocol.TField("acc", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField EXPECT_FIELD_DESC = new org.apache.thrift.protocol.TField("expect", org.apache.thrift.protocol.TType.DOUBLE, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SongExpectStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SongExpectTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String id; // required
  /**
   * 
   * @see Level
   */
  public @org.apache.thrift.annotation.Nullable Level level; // required
  public double acc; // required
  public double expect; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    /**
     * 
     * @see Level
     */
    LEVEL((short)2, "level"),
    ACC((short)3, "acc"),
    EXPECT((short)4, "expect");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // LEVEL
          return LEVEL;
        case 3: // ACC
          return ACC;
        case 4: // EXPECT
          return EXPECT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ACC_ISSET_ID = 0;
  private static final int __EXPECT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LEVEL, new org.apache.thrift.meta_data.FieldMetaData("level", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, Level.class)));
    tmpMap.put(_Fields.ACC, new org.apache.thrift.meta_data.FieldMetaData("acc", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.EXPECT, new org.apache.thrift.meta_data.FieldMetaData("expect", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SongExpect.class, metaDataMap);
  }

  public SongExpect() {
  }

  public SongExpect(
    java.lang.String id,
    Level level,
    double acc,
    double expect)
  {
    this();
    this.id = id;
    this.level = level;
    this.acc = acc;
    setAccIsSet(true);
    this.expect = expect;
    setExpectIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SongExpect(SongExpect other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetId()) {
      this.id = other.id;
    }
    if (other.isSetLevel()) {
      this.level = other.level;
    }
    this.acc = other.acc;
    this.expect = other.expect;
  }

  public SongExpect deepCopy() {
    return new SongExpect(this);
  }

  @Override
  public void clear() {
    this.id = null;
    this.level = null;
    setAccIsSet(false);
    this.acc = 0.0;
    setExpectIsSet(false);
    this.expect = 0.0;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getId() {
    return this.id;
  }

  public SongExpect setId(@org.apache.thrift.annotation.Nullable java.lang.String id) {
    this.id = id;
    return this;
  }

  public void unsetId() {
    this.id = null;
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return this.id != null;
  }

  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  /**
   * 
   * @see Level
   */
  @org.apache.thrift.annotation.Nullable
  public Level getLevel() {
    return this.level;
  }

  /**
   * 
   * @see Level
   */
  public SongExpect setLevel(@org.apache.thrift.annotation.Nullable Level level) {
    this.level = level;
    return this;
  }

  public void unsetLevel() {
    this.level = null;
  }

  /** Returns true if field level is set (has been assigned a value) and false otherwise */
  public boolean isSetLevel() {
    return this.level != null;
  }

  public void setLevelIsSet(boolean value) {
    if (!value) {
      this.level = null;
    }
  }

  public double getAcc() {
    return this.acc;
  }

  public SongExpect setAcc(double acc) {
    this.acc = acc;
    setAccIsSet(true);
    return this;
  }

  public void unsetAcc() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ACC_ISSET_ID);
  }

  /** Returns true if field acc is set (has been assigned a value) and false otherwise */
  public boolean isSetAcc() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ACC_ISSET_ID);
  }

  public void setAccIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ACC_ISSET_ID, value);
  }

  public double getExpect() {
    return this.expect;
  }

  public SongExpect setExpect(double expect) {
    this.expect = expect;
    setExpectIsSet(true);
    return this;
  }

  public void unsetExpect() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __EXPECT_ISSET_ID);
  }

  /** Returns true if field expect is set (has been assigned a value) and false otherwise */
  public boolean isSetExpect() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __EXPECT_ISSET_ID);
  }

  public void setExpectIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __EXPECT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((java.lang.String)value);
      }
      break;

    case LEVEL:
      if (value == null) {
        unsetLevel();
      } else {
        setLevel((Level)value);
      }
      break;

    case ACC:
      if (value == null) {
        unsetAcc();
      } else {
        setAcc((java.lang.Double)value);
      }
      break;

    case EXPECT:
      if (value == null) {
        unsetExpect();
      } else {
        setExpect((java.lang.Double)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case LEVEL:
      return getLevel();

    case ACC:
      return getAcc();

    case EXPECT:
      return getExpect();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case LEVEL:
      return isSetLevel();
    case ACC:
      return isSetAcc();
    case EXPECT:
      return isSetExpect();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof SongExpect)
      return this.equals((SongExpect)that);
    return false;
  }

  public boolean equals(SongExpect that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
        return false;
    }

    boolean this_present_level = true && this.isSetLevel();
    boolean that_present_level = true && that.isSetLevel();
    if (this_present_level || that_present_level) {
      if (!(this_present_level && that_present_level))
        return false;
      if (!this.level.equals(that.level))
        return false;
    }

    boolean this_present_acc = true;
    boolean that_present_acc = true;
    if (this_present_acc || that_present_acc) {
      if (!(this_present_acc && that_present_acc))
        return false;
      if (this.acc != that.acc)
        return false;
    }

    boolean this_present_expect = true;
    boolean that_present_expect = true;
    if (this_present_expect || that_present_expect) {
      if (!(this_present_expect && that_present_expect))
        return false;
      if (this.expect != that.expect)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetId()) ? 131071 : 524287);
    if (isSetId())
      hashCode = hashCode * 8191 + id.hashCode();

    hashCode = hashCode * 8191 + ((isSetLevel()) ? 131071 : 524287);
    if (isSetLevel())
      hashCode = hashCode * 8191 + level.getValue();

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(acc);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(expect);

    return hashCode;
  }

  @Override
  public int compareTo(SongExpect other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetId(), other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetLevel(), other.isSetLevel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLevel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.level, other.level);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetAcc(), other.isSetAcc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAcc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.acc, other.acc);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetExpect(), other.isSetExpect());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExpect()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.expect, other.expect);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("SongExpect(");
    boolean first = true;

    sb.append("id:");
    if (this.id == null) {
      sb.append("null");
    } else {
      sb.append(this.id);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("level:");
    if (this.level == null) {
      sb.append("null");
    } else {
      sb.append(this.level);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("acc:");
    sb.append(this.acc);
    first = false;
    if (!first) sb.append(", ");
    sb.append("expect:");
    sb.append(this.expect);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (id == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'id' was not present! Struct: " + toString());
    }
    if (level == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'level' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'acc' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'expect' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SongExpectStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SongExpectStandardScheme getScheme() {
      return new SongExpectStandardScheme();
    }
  }

  private static class SongExpectStandardScheme extends org.apache.thrift.scheme.StandardScheme<SongExpect> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SongExpect struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id = iprot.readString();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LEVEL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.level = Level.findByValue(iprot.readI32());
              struct.setLevelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ACC
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.acc = iprot.readDouble();
              struct.setAccIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // EXPECT
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.expect = iprot.readDouble();
              struct.setExpectIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetAcc()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'acc' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetExpect()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'expect' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, SongExpect struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.id != null) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeString(struct.id);
        oprot.writeFieldEnd();
      }
      if (struct.level != null) {
        oprot.writeFieldBegin(LEVEL_FIELD_DESC);
        oprot.writeI32(struct.level.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ACC_FIELD_DESC);
      oprot.writeDouble(struct.acc);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(EXPECT_FIELD_DESC);
      oprot.writeDouble(struct.expect);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SongExpectTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SongExpectTupleScheme getScheme() {
      return new SongExpectTupleScheme();
    }
  }

  private static class SongExpectTupleScheme extends org.apache.thrift.scheme.TupleScheme<SongExpect> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SongExpect struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.id);
      oprot.writeI32(struct.level.getValue());
      oprot.writeDouble(struct.acc);
      oprot.writeDouble(struct.expect);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SongExpect struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.id = iprot.readString();
      struct.setIdIsSet(true);
      struct.level = Level.findByValue(iprot.readI32());
      struct.setLevelIsSet(true);
      struct.acc = iprot.readDouble();
      struct.setAccIsSet(true);
      struct.expect = iprot.readDouble();
      struct.setExpectIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

