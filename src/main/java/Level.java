/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)", date = "2023-04-16")
public enum Level implements org.apache.thrift.TEnum {
  EZ(0),
  HD(1),
  IN(2),
  AT(3);

  private final int value;

  private Level(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static Level findByValue(int value) { 
    switch (value) {
      case 0:
        return EZ;
      case 1:
        return HD;
      case 2:
        return IN;
      case 3:
        return AT;
      default:
        return null;
    }
  }
}
