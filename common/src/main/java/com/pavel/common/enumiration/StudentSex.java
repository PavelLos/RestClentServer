package com.pavel.common.enumiration;

/**
 * enum пола
 */
public enum StudentSex {
  мужской(1, ConstForEnums.MALE),
  женский(2,ConstForEnums.FEMALE);

  private final int value;
  private String name;

  StudentSex(int value, String name) {
    this.value = value;
    this.name = name;
  }

  /**
   * получение значения 
   * @return значение 
   */
  public int getValue() {
    return value;
  }

  /**
   * получение пола по id
   * @param id
   * @return пол
   */
  public static String getById(int id) {
    for(StudentSex sex : StudentSex.values()) {
      if(id == sex.getValue()) {
        return sex.getName();
      }
    }
    return null;
  }

  /**
   * получение имени
   * @return имя
   */
  public String getName() {
    return name;
  }

  
}
