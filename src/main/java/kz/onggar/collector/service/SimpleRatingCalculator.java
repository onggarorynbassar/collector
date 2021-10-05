package kz.onggar.collector.service;

import kz.onggar.collector.component.LobbyType;

public interface SimpleRatingCalculator {

    /**
     * Вычисляет новый обычный рейтинг игрока в зависимости от занятого места в игре
     * <p>
     * {@link LobbyType#COMMON}<br>
     * за 1 место: +100<br>
     * за 2 место: +75<br>
     * за 3 место: +50<br>
     * за 4 место: +25<br>
     * за 5 место: -25<br>
     * за 6 место: -50<br>
     * за 7 место: -75<br>
     * за 8 место: -100<br>
     *
     * @param playerCurrentRating       Текущий обычный рейтинг игрока, которому мы высчитываем новый рейтинг<br><br>
     * @param place                     Место игрока которому высчитываем новый обычный рейтинг. Обычно от 1(лучший) до 8(последний)<br><br>
     * @param lobbyType              количество игроков в лобби<br><br>
     */
    int calculateNewRank(int playerCurrentRating, int place, LobbyType lobbyType);
}
