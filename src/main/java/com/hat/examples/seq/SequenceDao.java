package com.hat.examples.seq;

public interface SequenceDao {
	long getNextSequenceId(String key) throws SequenceException;
}
