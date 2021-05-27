package scala_exam.models

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

case class Request@JsonCreator()(@JsonProperty("min_age")minAge:Int,
                                 @JsonProperty("max_age")maxAge:Int,
                                 @JsonProperty("gender")gender:String,
                                 @JsonProperty("prefix_name")prefixName:String,
                                 @JsonProperty("Marital Status")maritalStatus:String,
                                 @JsonProperty("Number of Children")numberOfChildren:Int){
}