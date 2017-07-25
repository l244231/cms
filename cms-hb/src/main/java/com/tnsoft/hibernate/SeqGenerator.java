package com.tnsoft.hibernate;

import java.io.Serializable;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.EntityPersister;

public class SeqGenerator extends SequenceGenerator
{
  public Serializable generate(SessionImplementor session, Object obj)
  {
    Number id = (Number)session.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, session);
    if ((id != null) && (id.longValue() > 0L)) {
      return id;
    }
    return super.generate(session, obj);
  }
}