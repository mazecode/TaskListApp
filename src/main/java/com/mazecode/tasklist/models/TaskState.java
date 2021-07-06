package com.mazecode.tasklist.models;

import java.util.Arrays;

/**
 * Class TaskStatus
 *
 * @author Diego Feliú <diego.feliud@gmail.com> @DFELIU
 */
public enum TaskState {
    PENDING(0), COMPLETED(1), NOT_COMPLETED(2);

    private final int code;

    TaskState(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TaskState fromString(int value) {
        return Arrays.stream(TaskState.values())
                .filter(s -> s.code == value)
                .findFirst()
                .orElse(TaskState.PENDING);
    }
}
