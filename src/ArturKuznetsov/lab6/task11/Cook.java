package ArturKuznetsov.lab6.task11;

import ArturKuznetsov.lab6.task11.exceptions.InvalidCookNameException;

import java.time.DayOfWeek;
import java.util.Set;

public class Cook {
    private final String cookName;
    private final Set<DayOfWeek> workingDays;

    public Cook(String cookName, Set<DayOfWeek> workingDays) {
        if (cookName == null || cookName.isEmpty()) {
            throw new InvalidCookNameException(cookName);
        }
        this.cookName = cookName;
        this.workingDays = workingDays;
    }

    public boolean isWorking(DayOfWeek day) {
        return workingDays.contains(day);
    }

    public String getCookName() {
        return cookName;
    }

    public Set<DayOfWeek> getWorkingDays() {
        return workingDays;
    }

    @Override
    public String toString(){
        return String.format("Повар %s. | Рабочие дни повара: %s", getCookName(), getWorkingDays());
    }
}
