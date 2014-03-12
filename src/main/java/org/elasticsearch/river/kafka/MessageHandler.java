/* Copyright 2013 Endgame, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.river.kafka;

import java.nio.ByteBuffer;

import kafka.message.Message;

import org.elasticsearch.action.bulk.BulkRequestBuilder;

public abstract class MessageHandler {
  public static byte[] getMessageData(Message message) {
    ByteBuffer buf = message.payload();
    byte[] data = new byte[buf.remaining()];
    buf.get(data);
    return data;
  }

  public abstract void handle(BulkRequestBuilder bulkRequestBuilder, Message message) throws Exception;

}
