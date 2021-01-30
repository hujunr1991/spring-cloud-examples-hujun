package com.hujun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hujun.mapper.CountryMapper;
import com.hujun.model.Country;
import com.hujun.service.ICountryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 国家信息 服务实现类
 * </p>
 *
 * @author hujun
 * @since 2021-01-29
 */
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements ICountryService {

}
