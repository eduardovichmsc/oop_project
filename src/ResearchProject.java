import java.util.*;

public class ResearchProject {
    private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<Researcher> participants;

    public ResearchProject(String topic) {
        this.topic = topic;
        this.publishedPapers = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    public void addParticipant(User potentialParticipant) throws NotAResearcherException {
        if (potentialParticipant instanceof Researcher) {
            this.participants.add((Researcher) potentialParticipant);
            System.out.println("Участник успешно добавлен в проект: " + topic);
        } else {
            throw new NotAResearcherException("Ошибка: Пользователь " + potentialParticipant.getFirstName() + " не является исследователем!");
        }
    }

    public void addPublishedPaper(ResearchPaper paper) {
        if (!this.publishedPapers.contains(paper)) {
            this.publishedPapers.add(paper);
        }
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<ResearchPaper> getPublishedPapers() {
        return publishedPapers;
    }

    public void setPublishedPapers(List<ResearchPaper> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    public List<Researcher> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Researcher> participants) {
        this.participants = participants;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((topic == null) ? 0 : topic.hashCode());
        result = prime * result + ((publishedPapers == null) ? 0 : publishedPapers.hashCode());
        result = prime * result + ((participants == null) ? 0 : participants.hashCode());
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
        ResearchProject other = (ResearchProject) obj;
        if (topic == null) {
            if (other.topic != null)
                return false;
        } else if (!topic.equals(other.topic))
            return false;
        if (publishedPapers == null) {
            if (other.publishedPapers != null)
                return false;
        } else if (!publishedPapers.equals(other.publishedPapers))
            return false;
        if (participants == null) {
            if (other.participants != null)
                return false;
        } else if (!participants.equals(other.participants))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ResearchProject [topic=" + topic + ", publishedPapers=" + publishedPapers + ", participants="
                + participants + "]";
    }
}