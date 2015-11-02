package com.hat.examples.seq;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@TypeAlias(value = "sequence")
@Document(collection = "sequence")
public class SequenceId {

	@Id
	private String idSeq;

	private long seq;

	
	public SequenceId() {
		super();
	}

	@Override
	public String toString() {
		return "SequenceId [idSeq=" + idSeq + ", seq=" + seq + "]";
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

}
