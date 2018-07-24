
package br.com.vsj.curriculumvsj.model.entity;

/**
 * Classe modelo para os tipos de publicações.
 * @author vinicius
 * @version 1.0
 */
public enum PublicationType {
    
    Article("Article"),
    Abstract("Abstract"),
    Book("Book"),
    ConferencePaper("Conference Paper"), 
    ExtendedAbstract("ExtendedAbstract"),
    Other ("Other"),
    Poster ("Poster"),
    Thesis ("Thesis");

    private final String type;

    
    PublicationType(String type) {
        this.type = type;
    }

    public static PublicationType [] asList() {
        return PublicationType.values();
    }

    public String getType() {
        return type;
    }
}
