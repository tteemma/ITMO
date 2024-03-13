package model.Entity;

public enum Prepositions {
    All("Все"),
    Through("через"),
    To("к"),
    Her("Ее"),
    In("в"),
    From("с"),
    On("на"),
    And("и"),
    Of("из"),
    By("по"),
    Then("Затем")
    ;

    private final String preposition;
    Prepositions(String preposition ){
        this.preposition = preposition;
    }

    @Override
    public String toString() {
        return preposition;
    }
}
