package by.koronatech.office.paginationServices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PaginationClass {
    public static <T> List<T> getPage (List<T> list, Integer page, Integer pageSize) throws IllegalAccessException {
        if(pageSize<=0||page<=0)
        {
            System.out.println(page + " size " + pageSize);
            throw new IllegalAccessException("Invalid page size" + pageSize);
        }
        int fromIndex = (page-1)*pageSize;
        if(list==null||list.size()<fromIndex) return Collections.emptyList();

        return list.subList(fromIndex,Math.min(fromIndex+pageSize, list.size()));
    }
    public static <T> void doPaginated (Collection <T> fullList,Integer pageSize, Page<T> pageInterface)
    {
        final List<T> list = new ArrayList<>(fullList);
        if(pageSize==null||pageSize<=0||pageSize>list.size())
        {
            pageSize  = list.size();
        }
        final int numberPage = (int) Math.ceil((double) list.size()/(double)pageSize);
        for (int counterPage=0;counterPage<numberPage;)
        {
            final List<T> page = list.subList(counterPage*pageSize, Math.min(++counterPage*pageSize, list.size()));
            pageInterface.run(page);
        }

    }
}
