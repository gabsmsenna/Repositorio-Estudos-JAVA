package Repositorio_Estudos_JAVA.academy.nelioalves.cursojava.domain.PSet.Exercicios.ex1.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class LogEntry {
    private String username;
    private LocalDateTime moment;

    public LogEntry(String username, LocalDateTime moment) {
        this.username = username;
        this.moment = moment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogEntry logEntry)) return false;
        return Objects.equals(username, logEntry.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
