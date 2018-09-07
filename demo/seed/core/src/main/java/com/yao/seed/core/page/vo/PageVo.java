package com.yao.seed.core.page.vo;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
public class PageVo<T> implements Iterable<T> {

    private List<T> content;
    private long totalElements;
    private int totalPages;
    private int numberOfElements;
    private int number;
    private int size;
    private boolean first;
    private boolean last;
    private Class<T> cls;

    public PageVo() {

    }

    public PageVo(Class<T> cls) {
        this.setContent(new ArrayList<T>());
        this.cls = cls;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public PageVo copyProperties(Page page) {

        if (null == page)
            return this;

        this.setTotalElements(page.getTotalElements());
        this.setTotalPages(page.getTotalPages());
        this.setNumberOfElements(page.getNumberOfElements());
        this.setNumber(page.getNumber() + 1);
        this.setSize(page.getSize());
        this.setFirst(page.isFirst());
        this.setLast(page.isLast());

        List pageContent = page.getContent();
        if (null != pageContent && pageContent.size() > 0) {
            this.setContent(new ArrayList<>());
            pageContent.forEach(p -> {
                try {
                    T obj = this.cls.newInstance();
                    BeanUtils.copyProperties(p, obj);
                    this.getContent().add(obj);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }

        return this;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public PageVo copyPageInfo(Page page) {

        if (null == page)
            return this;

        this.setTotalElements(page.getTotalElements());
        this.setTotalPages(page.getTotalPages());
        this.setNumberOfElements(page.getNumberOfElements());
        this.setNumber(page.getNumber() + 1);
        this.setSize(page.getSize());
        this.setFirst(page.isFirst());
        this.setLast(page.isLast());

        return this;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public PageVo copyProperties(PageVo pageVo) {

        if (null == pageVo)
            return this;

        this.setTotalElements(pageVo.getTotalElements());
        this.setTotalPages(pageVo.getTotalPages());
        this.setNumberOfElements(pageVo.getNumberOfElements());
        this.setNumber(pageVo.getNumber());
        this.setSize(pageVo.getSize());
        this.setFirst(pageVo.isFirst());
        this.setLast(pageVo.isLast());

        List pageContent = pageVo.getContent();
        if (null != pageContent && pageContent.size() > 0) {
            this.setContent(new ArrayList<>());
            pageContent.forEach(p -> {
                try {
                    T obj = this.cls.newInstance();
                    BeanUtils.copyProperties(p, obj);
                    this.getContent().add(obj);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }

        return this;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    @Override
    public Iterator<T> iterator() {
        return this.getContent().iterator();
    }

}
