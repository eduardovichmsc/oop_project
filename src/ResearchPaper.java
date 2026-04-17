import java.util.*;

public class ResearchPaper {
    private String title;
    private List<Researcher> authors;
    private String journal;
    private int pages;
    private Date datePublished;
    private String doi;
    private int citations;

    public ResearchPaper(String title, List<Researcher> authors, String journal, int pages, Date datePublished, String doi, int citations) {
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.pages = pages;
        this.datePublished = datePublished;
        this.doi = doi;
        this.citations = citations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Researcher> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Researcher> authors) {
        this.authors = authors;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public int getCitations() {
        return citations;
    }

    public void setCitations(int citations) {
        this.citations = citations;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((authors == null) ? 0 : authors.hashCode());
        result = prime * result + ((journal == null) ? 0 : journal.hashCode());
        result = prime * result + pages;
        result = prime * result + ((datePublished == null) ? 0 : datePublished.hashCode());
        result = prime * result + ((doi == null) ? 0 : doi.hashCode());
        result = prime * result + citations;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResearchPaper other = (ResearchPaper) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (authors == null) {
            if (other.authors != null)
                return false;
        } else if (!authors.equals(other.authors))
            return false;
        if (journal == null) {
            if (other.journal != null)
                return false;
        } else if (!journal.equals(other.journal))
            return false;
        if (pages != other.pages)
            return false;
        if (datePublished == null) {
            if (other.datePublished != null)
                return false;
        } else if (!datePublished.equals(other.datePublished))
            return false;
        if (doi == null) {
            if (other.doi != null)
                return false;
        } else if (!doi.equals(other.doi))
            return false;
        if (citations != other.citations)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ResearchPaper [title=" + title + ", authors=" + authors + ", journal=" + journal + ", pages=" + pages
                + ", datePublished=" + datePublished + ", doi=" + doi + ", citations=" + citations + "]";
    }
}