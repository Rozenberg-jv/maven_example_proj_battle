package by.kolbun.belhard.j18.battle.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BattleResult {

    private int id;

    private Player winner;

    private Player looser;

    private boolean draw = false;
}
