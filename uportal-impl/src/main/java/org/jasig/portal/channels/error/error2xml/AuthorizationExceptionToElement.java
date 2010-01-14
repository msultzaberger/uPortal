/**
 * Copyright (c) 2000-2009, Jasig, Inc.
 * See license distributed with this file and available online at
 * https://www.ja-sig.org/svn/jasig-parent/tags/rel-10/license-header.txt
 */
package org.jasig.portal.channels.error.error2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.jasig.portal.AuthorizationException;

/**
 * Translates from a uPortal AuthorizationException to an XML element.
 * @author andrew.petro@yale.edu
 * @version $Revision$ $Date$
 * @since uPortal 2.5
 * @deprecated All IChannel implementations should be migrated to portlets
 */
@Deprecated
public final class AuthorizationExceptionToElement 
    implements IThrowableToElement{

    private ThrowableToElement throwableToElement = new ThrowableToElement();
    
    /* (non-Javadoc)
     * @see org.jasig.portal.channels.error.tt.IThrowableToElement#throwableToElement(java.lang.Throwable, org.w3c.dom.Document)
     */
    public Element throwableToElement(Throwable t, Document parentDoc) 
        throws IllegalArgumentException {
        
        Element element = this.throwableToElement.throwableToElement(t, parentDoc);
        
        if (! (t instanceof AuthorizationException))
            throw new IllegalArgumentException(t.getClass().getName() + 
                    " does not extend AuthorizationException");
        
        element.setAttribute("renderedAs", AuthorizationException.class.getName());
        
        return element;
    }

    /* (non-Javadoc)
     * @see org.jasig.portal.channels.error.tt.IThrowableToElement#supports(java.lang.Class)
     */
    public boolean supports(Class c) throws IllegalArgumentException {
        if (c == null)
            throw new IllegalArgumentException("Cannot support a null class.");
        
        if (! Throwable.class.isAssignableFrom(c))
            throw new IllegalArgumentException("Supports undefined on classes " +
                    "which are not and do not extend Throwable.  Class was " 
                    + c.getName());
        
        return AuthorizationException.class.isAssignableFrom(c);
    }

}