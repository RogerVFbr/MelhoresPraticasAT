package com.soundlab.repositories;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> {
    protected final List<T> repository = new ArrayList<>();
}
