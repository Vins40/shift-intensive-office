package by.koronatech.office.paginationServices;

import java.util.List;

public interface Page<T> {
    void run(List<T> item);
}
