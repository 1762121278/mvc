//package com.dfgx.user.validate.Bean;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//import org.hibernate.validator.constraints.Length;
//import org.hibernate.validator.constraints.Range;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//@Data
//@ToString
//@NoArgsConstructor
//public class DeptParam {
//    /*校验注解：
//    @Null   被注释的元素必须为 null
//    @NotNull    被注释的元素必须不为 null
//    @AssertTrue     被注释的元素必须为 true
//    @AssertFalse    被注释的元素必须为 false
//    @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
//    @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
//    @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
//    @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
//    @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
//    @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
//    @Past   被注释的元素必须是一个过去的日期
//    @Future     被注释的元素必须是一个将来的日期
//    @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式
//
//
//    Hibernate Validator提供的校验注解：
//    @NotBlank(message =)   验证字符串非null，且长度必须大于0
//    @Email  被注释的元素必须是电子邮箱地址
//    @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
//    @NotEmpty   被注释的字符串的必须非空
//    @Range(min=,max=,message=)  被注释的元素必须在合适的范围内*/
//
//    @NotNull
//    @Range(max = 10, min = 2, message = "用户id在2-10之间")
//    private Integer id;
//
//    @NotBlank
//    @Length(min = 2, max = 10, message = "部门名称长度2-10")
//    private String name;
//
//    @Size(max=10,message = "备注不超过十")
//    private String remark;
//}
