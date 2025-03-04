//
// ========================================================================
// Copyright (c) 1995 Mort Bay Consulting Pty Ltd and others.
//
// This program and the accompanying materials are made available under the
// terms of the Eclipse Public License v. 2.0 which is available at
// https://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
// which is available at https://www.apache.org/licenses/LICENSE-2.0.
//
// SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
// ========================================================================
//

package org.eclipse.jetty.quic.quiche.jna;

import java.nio.charset.Charset;

import com.sun.jna.ptr.PointerByReference;

public class char_pointer extends PointerByReference
{
    public String getValueAsString(int len, Charset charset)
    {
        return new String(getValue().getByteArray(0, len), charset);
    }

    public byte[] getValueAsBytes(int len)
    {
        return getValue().getByteArray(0, len);
    }
}
