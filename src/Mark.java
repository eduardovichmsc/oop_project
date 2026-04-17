public class Mark {
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;

    public Mark() {
        this.firstAttestation = 0.0;
        this.secondAttestation = 0.0;
        this.finalExam = 0.0;
    }

    public double getFirstAttestation() {
        return firstAttestation;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public double getTotalMark() {
        return firstAttestation + secondAttestation + finalExam;
    }

    public void setFirstAttestation(double firstAttestation) {
        if (firstAttestation >= 0 && firstAttestation <= 30) {
            this.firstAttestation = firstAttestation;
        } else {
            System.out.println("Ошибка: балл за аттестацию должен быть от 0 до 30");
        }
    }

    public void setSecondAttestation(double secondAttestation) {
        if (secondAttestation >= 0 && secondAttestation <= 30) {
            this.secondAttestation = secondAttestation;
        } else {
            System.out.println("Ошибка: балл за вторую аттестацию должен быть от 0 до 30");
        }
    }

    public void setFinalExam(double finalExam) {
        if (finalExam >= 0 && finalExam <= 40) {
            this.finalExam = finalExam;
        } else {
            System.out.println("Ошибка: балл за финальный экзамен должен быть от 0 до 40");
        }
    }

    @Override
    public String toString() {
        return "Mark [firstAttestation=" + firstAttestation + ", secondAttestation=" + secondAttestation
                + ", finalExam=" + finalExam + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.firstAttestation) ^ (Double.doubleToLongBits(this.firstAttestation) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.secondAttestation) ^ (Double.doubleToLongBits(this.secondAttestation) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.finalExam) ^ (Double.doubleToLongBits(this.finalExam) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mark other = (Mark) obj;
        if (Double.doubleToLongBits(this.firstAttestation) != Double.doubleToLongBits(other.firstAttestation)) {
            return false;
        }
        if (Double.doubleToLongBits(this.secondAttestation) != Double.doubleToLongBits(other.secondAttestation)) {
            return false;
        }
        return Double.doubleToLongBits(this.finalExam) == Double.doubleToLongBits(other.finalExam);
    }
}