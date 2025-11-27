package com.example.books.webapp.service;

import com.example.books.model.HasBook;
import com.example.books.model.ServiceStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookServiceService {

    private final Map<Long, HasBook> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public HasBook createService(HasBook request) {
        HasBook entity = new HasBook();
        entity.setId(idGenerator.getAndIncrement());
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setUserId(request.getUserId());
        entity.setPrice(request.getPrice());
        entity.setStatus(ServiceStatus.PENDING);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        store.put(entity.getId(), entity);
        return entity;
    }

    public Optional<HasBook> getServiceById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public HasBook updateService(Long id, HasBook request) {
        HasBook existing = store.get(id);
        Assert.notNull(existing, "响应不存在");
        if (existing.getStatus() != ServiceStatus.PENDING) {
            throw new IllegalStateException("仅可修改未被接受的响应");
        }
        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setUpdatedAt(LocalDateTime.now());
        return existing;
    }

    public void deleteService(Long id) {
        HasBook existing = store.get(id);
        Assert.notNull(existing, "响应不存在");
        if (existing.getStatus() != ServiceStatus.PENDING) {
            throw new IllegalStateException("仅可删除未被接受的响应");
        }
        store.remove(id);
    }

    public List<HasBook> getServicesByUserId(Long userId) {
        List<HasBook> result = new ArrayList<>();
        for (HasBook hasBook : store.values()) {
            if (userId.equals(hasBook.getUserId())) {
                result.add(hasBook);
            }
        }
        return result;
    }
}
