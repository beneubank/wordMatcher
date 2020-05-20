package com.wordMatcher.objects;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Double.NaN;

public class SearchCollection extends ArrayList<SearchItem> {

    private Double levenshteinHighTotal = 0.0, levenshteinLowTotal = NaN, jaroHighTotal = 0.0, jaroLowTotal = NaN,
    fuzzyHighTotal = 0.0, fuzzyLowTotal = NaN, matchScoreHigh = 0.0, matchScoreLow = NaN;
    //performs Collections.sort after we determine the match score
    public void score() {
        for (SearchItem item : this){
            //Normalize the data| normalizedNumber = (item-min(items)) / (max(items)-min(items))
            Double normalizedLT = (item.getLevenshteinDistanceTotal() - levenshteinLowTotal) / (levenshteinHighTotal - levenshteinLowTotal);
            Double normalizedJT = (item.getJaroWinklerDistanceTotal()- jaroLowTotal) / (jaroHighTotal - jaroLowTotal);
            Double normalizedFT = (item.getFuzzyDistanceTotal() - fuzzyLowTotal) / (fuzzyHighTotal - fuzzyLowTotal);
            //The greater the levenshtein distance the worse it is. We'll subtract that from the other scores we're combining
            Double finalScore = (normalizedJT * normalizedFT) - normalizedLT;
            item.setMatchScore(finalScore);
        }
        Collections.sort(this);
    }
    //override add method so we can record totals as they come in and replace any highs and lows
    @Override
    public boolean add(SearchItem item) {
        if (item.getLevenshteinDistanceTotal() > levenshteinHighTotal)  levenshteinHighTotal = item.getLevenshteinDistanceTotal();
        if (levenshteinLowTotal.isNaN() || item.getLevenshteinDistanceTotal() < levenshteinLowTotal) levenshteinLowTotal = item.getLevenshteinDistanceTotal();

        if (item.getFuzzyDistanceTotal() > fuzzyHighTotal)  fuzzyHighTotal = item.getFuzzyDistanceTotal();
        if (fuzzyLowTotal.isNaN() || item.getFuzzyDistanceTotal() < fuzzyLowTotal) fuzzyLowTotal = item.getFuzzyDistanceTotal();

        if (item.getJaroWinklerDistanceTotal() > jaroHighTotal)  jaroHighTotal = item.getJaroWinklerDistanceTotal();
        if (jaroLowTotal.isNaN() || item.getJaroWinklerDistanceTotal() < jaroLowTotal) jaroLowTotal = item.getJaroWinklerDistanceTotal();

        return super.add(item);
    }
    //Use to check score high and lows are all there after adding.
    public String toTotals() {
        return "SearchCollection{" +
                "levenshteinHighTotal=" + levenshteinHighTotal +
                ", levenshteinLowTotal=" + levenshteinLowTotal +
                ", jaroHighTotal=" + jaroHighTotal +
                ", jaroLowTotal=" + jaroLowTotal +
                ", fuzzyHighTotal=" + fuzzyHighTotal +
                ", fuzzyLowTotal=" + fuzzyLowTotal +
                '}';
    }
}
