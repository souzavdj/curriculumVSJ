package br.com.vsj.curriculumvsj.model.entity;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Classe modelo para as publicações.
 * @author vinicius
 * @version 1.1
 */
public class Publication {
    
    private String title;
    
    private List<Author> authors;
    
    private Date publicationDate;
    
    private PublicationType type;
    
    private String conference;
    
    private String DOI;
    
    private Address Local;
    
    private File file;

    public Publication() {
    }

    public Publication(String title, List<Author> authors, Date publicationDate, PublicationType type, String conference, String DOI, Address Local, File file) {
        this.title = title;
        this.authors = authors;
        this.publicationDate = publicationDate;
        this.type = type;
        this.conference = conference;
        this.DOI = DOI;
        this.Local = Local;
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public Address getLocal() {
        return Local;
    }

    public void setLocal(Address Local) {
        this.Local = Local;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
}
