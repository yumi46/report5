
package jp.ac.uryukyu.ie.e185727;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;


    public LivingThing(String name, int hitPoint, int attack) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }


    public String getName() {
        return name;
    }

    public  int getHitPoint(){
        return hitPoint;
    }

    public void setHitPoint(int damage){
        this.hitPoint -= damage;
    }

    public int getAttack(){
        return attack;
    }

    /**
     * attack()の処理
     * @if 死んでいない場合、ランダムでダメージを与える。
     * @printf 与えたダメージの結果
     * @elseif 死んでいる場合、
     * @printf 死んでいる結果
     */

    public void attack(LivingThing opponent) {
        if (dead == false) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        } else if (dead == true) {
            System.out.printf("%sは死んでいるよ。\n", name);
        }
    }
    /**
     * wounded()の処理
     * @if hitpointがマイナスなら、dead
     * @printf 倒れた結果
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }

    }
}




