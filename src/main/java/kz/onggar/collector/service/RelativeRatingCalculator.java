package kz.onggar.collector.service;

import kz.onggar.collector.component.LobbyType;

public interface RelativeRatingCalculator {

    /**
     * Вычисляет новый относительный рейтинг игрока на основе своего рейтинга и среднего рейтинга других игроков
     * <p>
     * По формуле:<br><br>
     * <p>
     * Если занятое место в игре (place) в первой половине всех игроков(lobbyType):<br>
     * result = (1 - (playerCurrentRating / 30000)) * ((30000 - (playerCurrentRating - averageOtherPlayersRating)) / 30000) * placeMultiplier<br><br>
     * <p>
     * Если занятое место в игре (place) во второй половине всех игроков(lobbyType):<br>
     * result = ((30000 + (playerCurrentRating - averageOtherPlayersRating)) / 30000) * placeMultiplier<br><br>
     * <p>
     * placeMultiplier когда {@link LobbyType#COMMON}<br>
     * за 1 место: +100<br>
     * за 2 место: +70<br>
     * за 3 место: +40<br>
     * за 4 место: +20<br>
     * за 5 место: -20<br>
     * за 6 место: -40<br>
     * за 7 место: -70<br>
     * за 8 место: -100<br>
     *
     * @param playerCurrentRating       Текущий относительный рейтинг игрока, которому мы высчитываем новый рейтинг<br><br>
     * @param averageOtherPlayersRating Средняя от текущих относительных рейтингов остальных игроков в лобби<br><br>
     * @param place                     Место игрока которому высчитываем новый относительный рейтинг. Обычно от 1(лучший) до 8(последний)<br><br>
     * @param lobbyType              количество игроков в лобби<br><br>
     * @implSpec Все вычисления должны быть в double, а конечный результат обернут в Math.round()
     */
    int calculateNewRank(int playerCurrentRating, int averageOtherPlayersRating, int place, LobbyType lobbyType);
}
