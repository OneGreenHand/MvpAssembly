package com.ogh.module.common.base;

import com.ogh.module.common.bean.BaseBean;

/**
 * @author lucas
 * @package com.goume.heyding.base.mvp
 * @date 2018/7/9
 */
public interface BaseSwipeView<B extends BaseBean> extends BaseRequestView<B> {
    void resetRefreshView();
    void loadMoreFailView();
}
