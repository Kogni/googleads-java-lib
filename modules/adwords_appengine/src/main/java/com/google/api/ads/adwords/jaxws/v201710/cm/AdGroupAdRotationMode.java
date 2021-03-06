// Copyright 2017 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package com.google.api.ads.adwords.jaxws.v201710.cm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             The ad rotation mode wrapper class to allow for clearing of the AdRotationMode field.
 *           
 * 
 * <p>Java class for AdGroupAdRotationMode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupAdRotationMode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adRotationMode" type="{https://adwords.google.com/api/adwords/cm/v201710}AdRotationMode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupAdRotationMode", propOrder = {
    "adRotationMode"
})
public class AdGroupAdRotationMode {

    @XmlSchemaType(name = "string")
    protected AdRotationMode adRotationMode;

    /**
     * Gets the value of the adRotationMode property.
     * 
     * @return
     *     possible object is
     *     {@link AdRotationMode }
     *     
     */
    public AdRotationMode getAdRotationMode() {
        return adRotationMode;
    }

    /**
     * Sets the value of the adRotationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdRotationMode }
     *     
     */
    public void setAdRotationMode(AdRotationMode value) {
        this.adRotationMode = value;
    }

}
