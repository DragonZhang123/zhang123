package Yest;

public class Renshiyu {
    private String clothes;
    private Boolean whetherBathe;
    private Boolean hasBug;

    public Renshiyu(String clothes) {
        this.clothes = "万年马甲";
        this.whetherBathe=false;
    }
    private void poisoning(){
        if (this.whetherBathe==false){
            System.out.println("正在放毒！");
        }
    }
    private void Spoiled(){
        if (this.whetherBathe==false){
            System.out.println("正在撒娇！");
        }
    }
    public void code(){
        if (this.hasBug==true){
            System.out.println("我不改！为啥让我改！");
        }
    }
    public String getClothes() {
        return clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public Boolean getWhetherBathe() {
        return whetherBathe;
    }

    public void setWhetherBathe(Boolean whetherBathe) {
        this.whetherBathe = whetherBathe;
    }
}
