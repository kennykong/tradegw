/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.hofon.member.common.facade.MemberBasicInfoFacade;
import com.hofon.member.common.facade.MerchantFacade;
import com.hofon.member.common.model.MemberBasicInfo;
import com.hofon.member.common.model.Merchant;
import com.hofon.trade.facade.NoGeneratorFacade;
import com.hofon.trade.facade.TradeProcessFacade;
import com.hofon.trade.facade.TradeQueryFacade;
import com.hofon.tradegw.facade.model.Royalty;
import com.hofon.tradegw.facade.model.TradegwResultCode;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.lang.StringUtil;
import com.zhuking.common.util.money.Money;
import com.zhuking.validate.ValidatorUtil;

/**
 * 收单网关接口父类
 * @author xilu.tong
 * @version $Id: TradegwService.java, v0.1 2015年11月27日 下午4:22:19 xilu.tong Exp $
 */
public class TradegwService implements ITradegwService {

    private static final Logger   logger = LoggerFactory.getLogger(TradegwService.class);

    @Resource(name = "tradeQueryFacade")
    private TradeQueryFacade      tradeQueryFacade;

    @Resource(name = "tradeProcessFacade")
    private TradeProcessFacade    tradeProcessFacade;

    @Resource(name = "noGeneratorFacade")
    private NoGeneratorFacade     noGeneratorFacade;

    @Resource(name = "memberBasicInfoFacade")
    private MemberBasicInfoFacade memberBasicInfoFacade;

    @Resource(name = "merchantFacade")
    private MerchantFacade        merchantFacade;

    /** 
     * @see com.hofon.tradegw.biz.ITradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        return null;
    }

    protected MemberBasicInfo getMemberBasicInfoFromCache(String token) {
        BaseResult<MemberBasicInfo> result = memberBasicInfoFacade.getMemberBasicInfoByToken(token);
        if (!result.isSuccess()) {
            logger.warn("查询会员基本信息失败，token=" + token + " ;result=" + result);
        }
        return result.getData();
    }

    protected MemberBasicInfo getBasisMemeber(String memberId) {
        BaseResult<MemberBasicInfo> result = memberBasicInfoFacade
            .getMemberBasicInfoByMemberId(memberId);
        if (!result.isSuccess()) {
            logger.warn("查询会员基本信息失败，memberId=" + memberId + " ;result=" + result);
            throw new RuntimeException(result.getErrorMsg());
        }
        return result.getData();
    }

    protected Merchant getMerchant(String merchantId) {
        if (StringUtil.isBlank(merchantId)) {
            // TODO 后续更改
            Merchant merchant = new Merchant();
            merchant.setMerchantId("20000001");
            merchant.setMerchantName("华方医护站");
            return merchant;
        }
        BaseResult<Merchant> result = merchantFacade.getByMerchantId(merchantId);
        if (!result.isSuccess()) {
            logger.warn("查询商户异常，merchantId=" + merchantId + " ;result=" + result);
            throw new RuntimeException(result.getErrorMsg());
        }
        return result.getData();
    }

    /** 获得分润金额 */
    protected Money getSplitAmount(List<Royalty> royalties) {
        Money splitAmount = new Money(0, 0);
        if (CollectionUtils.isEmpty(royalties)) {
            return splitAmount;
        }
        for (Royalty royalty : royalties) {
            splitAmount.addTo(new Money(royalty.getAmount()));
        }
        return splitAmount;
    }

    protected BasePublicResponse buildSystemError() {
        return buildFail(TradegwResultCode.SYSTEM_ERROR.getCode(),
            TradegwResultCode.SYSTEM_ERROR.getMsg());
    }

    protected BasePublicResponse buildResponse(TradegwResultCode resultCode) {
        return buildFail(resultCode.getCode(), resultCode.getMsg());
    }

    /** 设置失败返回对象 */
    protected void setFailResponse(BasePublicResponse response, String merchantId,
                                   TradegwResultCode resultCode) {
        response.setIs_success('0');
        response.setError_code(resultCode.getCode());
        response.setError_msg(resultCode.getMsg());
    }

    /*
     * 校验所有传入参数
     * @param param
     */
    protected void validateParam(Object param) {
        List<String> errorList = ValidatorUtil.validateAll(param);
        if (!CollectionUtils.isEmpty(errorList)) {
            throw new IllegalArgumentException(errorList.toString());
        }
    }

    protected BasePublicResponse buildFail(String errorCode, String errorMsg) {
        BasePublicResponse response = new BasePublicResponse();
        response.setError_code(errorCode);
        response.setError_msg(errorMsg);
        response.setIs_success('0');
        return response;
    }

    /**
     * Getter method for property <tt>tradeQueryFacade</tt>.
     * 
     * @return property value of tradeQueryFacade
     */
    public TradeQueryFacade getTradeQueryFacade() {
        return tradeQueryFacade;
    }

    /**
     * Getter method for property <tt>tradeProcessFacade</tt>.
     * 
     * @return property value of tradeProcessFacade
     */
    public TradeProcessFacade getTradeProcessFacade() {
        return tradeProcessFacade;
    }

    /**
     * Getter method for property <tt>noGeneratorFacade</tt>.
     * 
     * @return property value of noGeneratorFacade
     */
    public NoGeneratorFacade getNoGeneratorFacade() {
        return noGeneratorFacade;
    }

    /**
     * Getter method for property <tt>merchantFacade</tt>.
     * 
     * @return property value of merchantFacade
     */
    public MerchantFacade getMerchantFacade() {
        return merchantFacade;
    }

}
