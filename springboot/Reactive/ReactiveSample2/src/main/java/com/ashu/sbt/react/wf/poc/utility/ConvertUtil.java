/**
 * 
 */
package com.ashu.sbt.react.wf.poc.utility;

import org.springframework.beans.BeanUtils;

import com.ashu.sbt.react.wf.poc.dto.ProductDto;
import com.ashu.sbt.react.wf.poc.ent.Product;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
public class ConvertUtil {

    public static ProductDto entToDto(Product prd) {
        ProductDto pdto = new ProductDto();
        BeanUtils.copyProperties(prd, pdto);
        return pdto;
    }

    public static Product dtoToEnt(ProductDto dto) {
        Product prd = new Product();
        BeanUtils.copyProperties(dto, prd);
        return prd;
    }
}
