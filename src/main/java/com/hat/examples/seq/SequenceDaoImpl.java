package com.hat.examples.seq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository
public class SequenceDaoImpl implements SequenceDao {

	@Autowired
	private MongoOperations mongoOperation;

	public long getNextSequenceId(String key) throws SequenceException {
		
	  Query query = new Query(Criteria.where("idSeq").is(key));

	  Update update = new Update();
	  update.inc("seq", 1);

	  FindAndModifyOptions options = new FindAndModifyOptions();
	  options.returnNew(true);

	  SequenceId seqId = 
            mongoOperation.findAndModify(query, update, options, SequenceId.class);

	  if (seqId == null) {
		throw new SequenceException("Unable to get sequence id for key : " + key);
	  }

	  return seqId.getSeq();

	}

}

