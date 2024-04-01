package com.personal;

import java.io.File;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicLong;

public class SizeOfFileAction extends RecursiveAction {
    private final File file;
    private final AtomicLong sizeAccumulator;

    public SizeOfFileAction(File file, AtomicLong sizeAccumulator) {
        this.file = file;
        this.sizeAccumulator = sizeAccumulator;
    }
    public SizeOfFileAction(String file, AtomicLong sizeAccumulator) {
        this(new File(file), sizeAccumulator);
    }

    @Override
    protected void compute() {
        if (file.isFile()) {
            sizeAccumulator.addAndGet(file.length());
        } else {
            final File[] children = file.listFiles();
            if (children != null) {
                for (final File child : children) {
                    ForkJoinTask.invokeAll(new SizeOfFileAction(child, sizeAccumulator));
                }
            }
        }
    }
}
