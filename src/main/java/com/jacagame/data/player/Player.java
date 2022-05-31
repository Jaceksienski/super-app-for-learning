package com.jacagame.data.player;

import com.jacagame.data.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;


@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "player")
public class Player {
    @Id
    private long id;
    private long gold;
    private int lvl;
    private long exp;
    private int hpCurrent;
    private int hpMax;
    private int attAttack;
    private int attDefence;

    public Player(User user) {
        Logger LOGGER = LogManager.getLogger();
        LOGGER.log(Level.INFO, "seting up new player");
        setId(user.getId());
        setGold(PlayerStartStatistics.START_GOLD);
        setLvl(PlayerStartStatistics.START_LVL);
        setExp(PlayerStartStatistics.START_EXP);
        setHpMax(PlayerStartStatistics.START_HP);
        setHpCurrent(getHpMax());
        setAttAttack(PlayerStartStatistics.START_ATTACK);
        setAttDefence(PlayerStartStatistics.START_DEFENCE);
    }
}
