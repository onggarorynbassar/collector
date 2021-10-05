package kz.onggar.collector.service;

import kz.onggar.collector.component.LobbyType;

public interface CompetitiveRatingCalculator {

    /**
     * Вычисляет новый соревновательный рейтинг игрока в зависимости от занятого места в игре
     * <p>
     * {@link LobbyType#COMMON}<br>
     * за 1 место: +100<br>
     * за 2 место: +70<br>
     * за 3 место: +25<br>
     * за 4 место: 0<br>
     * за 5 место: -25<br>
     * за 6 место: -50<br>
     * за 7 место: -75<br>
     * за 8 место: -100<br>
     *
     * @param playerCurrentRating       Текущий соревновательный рейтинг игрока, которому мы высчитываем новый рейтинг<br><br>
     * @param place                     Место игрока которому высчитываем новый соревновательный рейтинг. Обычно от 1(лучший) до 8(последний)<br><br>
     * @param lobbyType              количество игроков в лобби<br><br>
     */
    int calculateNewRank(int playerCurrentRating, int place, LobbyType lobbyType);
}
