/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openjena.riot.tokens;

public class TokenizerWrapper implements Tokenizer
{

    private final Tokenizer other ;

    public TokenizerWrapper(Tokenizer other)
    {
        this.other = other ;
    }
    
    @Override
    public long getColumn()
    {
        return other.getColumn() ;
    }

    @Override
    public long getLine()
    {
        return other.getLine() ;
    }

    @Override
    public boolean hasNext()
    {
        return other.hasNext() ;
    }

    @Override
    public boolean eof()
    {
        return other.eof() ;
    }

    @Override
    public Token next()
    {
        return other.next();
    }

    @Override
    public Token peek()
    {
        return other.peek() ;
    }

    // @Override
    @Override
    public void remove()
    {
        other.remove() ;
    }

    // @Override
    @Override
    public void close()
    {
        other.close() ;
    }
}
