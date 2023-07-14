package com.cybersoft.osahaneat.imp;

import com.cybersoft.osahaneat.request.OrderRequest;

public interface OrderRepositoryImp {
    boolean insertOrder (OrderRequest orderRequest);
}
