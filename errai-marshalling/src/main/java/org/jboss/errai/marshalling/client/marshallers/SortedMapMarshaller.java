/*
 * Copyright 2011 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.marshalling.client.marshallers;

import java.util.SortedMap;
import java.util.TreeMap;

import org.jboss.errai.marshalling.client.api.MarshallingSession;
import org.jboss.errai.marshalling.client.api.annotations.AlwaysQualify;
import org.jboss.errai.marshalling.client.api.annotations.ClientMarshaller;
import org.jboss.errai.marshalling.client.api.annotations.ImplementationAliases;
import org.jboss.errai.marshalling.client.api.annotations.ServerMarshaller;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.util.SimpleTypeLiteral;

/**
 * @author Mike Brock <cbrock@redhat.com>
 */
@ClientMarshaller
@ServerMarshaller
@AlwaysQualify
@ImplementationAliases({TreeMap.class})
public class SortedMapMarshaller extends MapMarshaller<SortedMap<Object, Object>> {

  @Override
  public Class<SortedMap<Object, Object>> getTypeHandled() {
    return SimpleTypeLiteral.<SortedMap<Object, Object>>ofRawType(SortedMap.class).get();
  }

  @SuppressWarnings("unchecked")
  @Override
  public SortedMap<Object, Object> demarshall(final EJValue o, final MarshallingSession ctx) {
    return doDemarshall(new TreeMap(), o, ctx);
  }
  
  @Override
  public SortedMap[] getEmptyArray() {
    return new TreeMap[0];
  }
}
