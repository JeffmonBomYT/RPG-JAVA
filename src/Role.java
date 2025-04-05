public class Role {

  private String name;
  private int hp;
  private int Hab1;
  private int Hab2;
  private int Hab3;

  public Role(String name, int hp, int Hab1, int Hab2, int Hab3) {
      this.name = name;
      this.hp = hp;
      this.Hab1 = Hab1;
      this.Hab2 = Hab2;
      this.Hab3 = Hab3;
  }

  public void setName(String name) {
      this.name = name;
  }

  public void setHp(int hp) {
      this.hp = hp;
  }

  public void setSkill1(int Hab1) {
      this.Hab1 = Hab1;
  }

  public void setSkill2(int Hab2) {
      this.Hab2 = Hab2;
  }

  public void setSkill3(int Hab3) {
      this.Hab3 = Hab3;
  }

  public String getName() {
      return name;
  }

  public int getHp() {
      return hp;
  }

  public int getSkill1() {
      return Hab1;
  }

  public int getSkill2() {
      return Hab2;
  }

  public int getSkill3() {
      return Hab3;
  }

  public int getChoice(int choice) {
      switch (choice) {
          case 1:
              return Hab1;
          case 2:
              return Hab2;
          case 3:
              return Hab3;
          default:
              break;
      }
      return 0;
  }
}