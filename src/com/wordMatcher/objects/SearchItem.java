package com.wordMatcher.objects;

import org.apache.commons.lang3.StringUtils;
import java.util.Locale;
import java.util.Arrays;

import static java.lang.Double.NaN;

public class SearchItem implements Comparable<SearchItem>{

    private String title, keyword, term;

    private String[] keywords;
    private Double levenshteinDistanceTotal;
    private Integer levenshteinDistanceKeywords;
    private Integer levenshteinDistanceTitle;
    private Double jaroWinklerDistanceTotal;
    private Double jaroWinklerDistanceKeywords;
    private Double jaroWinklerDistanceTitle;
    private Integer fuzzyDistanceKeywords = 0;
    private Integer fuzzyDistanceTitle = 0;
    private Double fuzzyDistanceTotal = NaN;
    private Double matchScore = 0.0;


    public SearchItem(String term, String title, String keyword)
    {
        if (title == null) title = "";
        else this.title = title;
        if (keyword == null)
        {
            keyword = ""; Arrays.fill(keywords, null);
        }
        else {
            this.keyword = keyword;
            this.keywords = keyword.split(",");
        }
        if (term == null) term = "";
        else this.term = term;

        setScores(this.term);
    }

    public String getTitle() {
        return title;
    }
    public String[] getKeywords() {
        return keywords;
    }
    public Double getLevenshteinDistanceTotal() {
        return levenshteinDistanceTotal;
    }
    public Double getJaroWinklerDistanceTotal() {
        return jaroWinklerDistanceTotal;
    }

    public Integer getLevenshteinDistanceKeywords() {
        return levenshteinDistanceKeywords;
    }

    public Double getJaroWinklerDistanceKeywords() {
        return jaroWinklerDistanceKeywords;
    }

    public Double getJaroWinklerDistanceTitle() {
        return jaroWinklerDistanceTitle;
    }
    public Double getFuzzyDistanceTotal() {
        return fuzzyDistanceTotal;
    }
    public Integer getFuzzyDistanceKeywords() {
        return fuzzyDistanceKeywords;
    }
    public Integer getFuzzyDistanceTitle() {
        return fuzzyDistanceTitle;
    }
    //Scores the item for the input string
    private void setScores(String input) {
        input = input.toLowerCase().replace(" ","");
        String title = this.title.replace(" ","").toLowerCase();
        fuzzyDistanceTitle = StringUtils.getFuzzyDistance(title,input, Locale.ENGLISH);
        jaroWinklerDistanceTitle = StringUtils.getJaroWinklerDistance(title,input);
        levenshteinDistanceTitle = StringUtils.getLevenshteinDistance(title,input);
        int finalFuzzyKScore = 0,
            finalLevenshteinKScore = 0;
        Double finalJaroKScore = 0.0;
        for (String keyword: keywords){
            keyword = keyword.replace(" ","").toLowerCase();

            int fuzzscore = StringUtils.getFuzzyDistance(keyword,input, Locale.ENGLISH);
            if (fuzzscore > finalFuzzyKScore) finalFuzzyKScore = fuzzscore;

            Double jaroscore = StringUtils.getJaroWinklerDistance(keyword,input);
            if (jaroscore > finalJaroKScore) finalJaroKScore = jaroscore;

            int levenshteinscore = StringUtils.getLevenshteinDistance(keyword,input);
            if (levenshteinscore > finalLevenshteinKScore) finalLevenshteinKScore = levenshteinscore;

        }
        fuzzyDistanceKeywords = finalFuzzyKScore;
        jaroWinklerDistanceKeywords = finalJaroKScore;
        levenshteinDistanceKeywords = finalLevenshteinKScore;
        //Weight titles heavier than keywords
        fuzzyDistanceTotal = fuzzyDistanceTitle * 1.5 + fuzzyDistanceKeywords;
        jaroWinklerDistanceTotal = jaroWinklerDistanceTitle * 1.5 + jaroWinklerDistanceKeywords;
        levenshteinDistanceTotal = levenshteinDistanceTitle * 1.5 + levenshteinDistanceKeywords;
    }

    public Double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Double matchScore) {
        this.matchScore = matchScore;
    }

    public int compareTo(SearchItem item){

        int lastCmp = matchScore.compareTo(item.getMatchScore());
        int compared = -(lastCmp != 0 ? lastCmp : matchScore.compareTo(item.getMatchScore()));
        //System.out.println(matchScore + " : " + item.getMatchScore() + " compared :" + compared);
        return compared;
    }


    /*
    public String toString() {
        return "SearchItem{" +
                "title='" + title + '\'' +
                ", keywords=" + Arrays.toString(keywords) +
                ", levenshteinDistanceTotal=" + levenshteinDistanceTotal +
                ", levenshteinDistanceKeywords=" + levenshteinDistanceKeywords +
                ", levenshteinDistanceTitle=" + levenshteinDistanceTitle +
                ", jaroWinklerDistanceTotal=" + jaroWinklerDistanceTotal +
                ", jaroWinklerDistanceKeywords=" + jaroWinklerDistanceKeywords +
                ", jaroWinklerDistanceTitle=" + jaroWinklerDistanceTitle +
                ", fuzzyDistanceTotal=" + fuzzyDistanceTotal +
                ", fuzzyDistanceKeywords=" + fuzzyDistanceKeywords +
                ", fuzzyDistanceTitle=" + fuzzyDistanceTitle +
                ", matchScore=" + matchScore +
                "}\n";
    }
    */
    @Override
    public String toString() {
        return "SearchItem{" +
                "title='" + title + '\'' +
                ", matchScore= [" + matchScore +
                "]}\n";
    }
}
