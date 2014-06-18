/*
 * Copyright 2014 Real Logic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.real_logic.aeron.mediadriver;

import uk.co.real_logic.aeron.mediadriver.buffer.BufferRotator;

public class NewReceiveBufferEvent
{
    public static final int STATE_PENDING = 1;
    public static final int STATE_READY = 2;

    private final long sessionId;
    private final long channelId;
    private final long termId;
    private final BufferRotator buffer;
    private final UdpDestination destination;
    private int state;

    public NewReceiveBufferEvent(final UdpDestination destination,
                                 final long sessionId,
                                 final long channelId,
                                 final long termId,
                                 final BufferRotator buffer)
    {
        this.sessionId = sessionId;
        this.channelId = channelId;
        this.termId = termId;
        this.buffer = buffer;
        this.destination = destination;
        this.state = STATE_PENDING;
    }

    public UdpDestination destination()
    {
        return destination;
    }

    public long sessionId()
    {
        return sessionId;
    }

    public long channelId()
    {
        return channelId;
    }

    public long termId()
    {
        return termId;
    }

    public int state()
    {
        return state;
    }

    public void state(final int state)
    {
        this.state = state;
    }

    public BufferRotator buffer()
    {
        return buffer;
    }
}