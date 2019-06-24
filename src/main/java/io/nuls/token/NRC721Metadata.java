/**
 * MIT License
 * <p>
 * Copyright (c) 2017-2018 nuls.io
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.nuls.token;

import io.nuls.contract.sdk.Address;
import io.nuls.contract.sdk.Contract;
import io.nuls.contract.sdk.Msg;
import io.nuls.token.base.NRC721MetadataBase;

import java.math.BigInteger;

import static io.nuls.contract.sdk.Utils.require;

/**
 * @author: PierreLuo
 * @date: 2019-06-10
 */
public class NRC721Metadata extends NRC721MetadataBase implements Contract {

    public NRC721Metadata(String name, String symbol) {
        super(name, symbol);
    }

    public boolean mint(Address to, BigInteger tokenId) {
        onlyMinter();
        super.mintBase(to, tokenId);
        return true;
    }

    public boolean mintWithTokenURI(Address to, BigInteger tokenId, String tokenURI) {
        onlyMinter();
        super.mintWithTokenURIBase(to, tokenId, tokenURI);
        return true;
    }

    public void burn(Address owner, BigInteger tokenId) {
        require(isApprovedOrOwner(Msg.sender(), tokenId), "NRC721: transfer caller is not owner nor approved");
        super.burnBase(owner, tokenId);
    }

}
