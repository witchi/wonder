/*
 * Copyright (C) NetStruxr, Inc. All rights reserved.
 *
 * This software is published under the terms of the NetStruxr
 * Public Software License version 0.5, a copy of which has been
 * included with this distribution in the LICENSE.NPL file.  */

package er.bugtracker;
import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import er.bugtracker.People;

public class ViewUser extends WOComponent {

    public ViewUser(WOContext aContext) {
        super(aContext);
    }

    public boolean isStateless() { return true; }

    protected People _user;
    public People user() {
        if (_user==null)
            _user=(People)valueForBinding("user");
        return _user;
    }
    public void reset() {
        super.reset();
        _user=null;
    }

    public boolean userIsNotEngineering() {
        return user()!=null && !user().isEngineeringAsBoolean();
    }
    public boolean userIsNotSelf() {
        return user()!=null && user()!=((Session)session()).getUser();
    }    
}