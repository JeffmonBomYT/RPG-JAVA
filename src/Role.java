public class Role {

  private String name;
  private int health;
  private int skill1;
  private int skill2;
  private int skill3;

  public Role(String name, int health, int skill1, int skill2, int skill3) {
      this.name = name;
      this.health = health;
      this.skill1 = skill1;
      this.skill2 = skill2;
      this.skill3 = skill3;
  }

  public void setName(String name) {
      this.name = name;
  }

  public void setHealth(int health) {
      this.health = health;
  }

  public void setSkill1(int skill1) {
      this.skill1 = skill1;
  }

  public void setSkill2(int skill2) {
      this.skill2 = skill2;
  }

  public void setSkill3(int skill3) {
      this.skill3 = skill3;
  }

  public String getName() {
      return name;
  }

  public int getHealth() {
      return health;
  }

  public int getSkill1() {
      return skill1;
  }

  public int getSkill2() {
      return skill2;
  }

  public int getSkill3() {
      return skill3;
  }

  public int getChoice(int choice) {
      switch (choice) {
          case 1:
              return skill1;
          case 2:
              return skill2;
          case 3:
              return skill3;
          default:
              break;
      }
      return 0;
  }
}