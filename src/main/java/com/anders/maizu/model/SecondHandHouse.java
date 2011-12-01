package com.anders.maizu.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 二手房
 * 
 * @author Anders Zhu
 * 
 */
@Entity
@Table(name = "tb_second_hand_house")
public class SecondHandHouse implements Serializable {

	private static final long serialVersionUID = -8981569640271697506L;

	/**
	 * 编号（主键）
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * 标题
	 */
	@Column(nullable = false, length = 50, unique = true)
	private String title;
	/**
	 * 楼盘名称
	 */
	@Column(nullable = false, length = 50)
	private String name;
	/**
	 * 省、自治区、直辖市（对应区域配置表类型0）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "province_id")
	private Area province;
	/**
	 * 城市（对应区域配置表类型1）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private Area city;
	/**
	 * 区、县、市（对应区域配置表类型2）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id")
	private Area district;
	/**
	 * 详细地址
	 */
	@Column(nullable = false, length = 100)
	private String address;
	/**
	 * 售价
	 */
	@Column(nullable = false, scale = 2)
	private BigDecimal price;
	/**
	 * 建筑面积
	 */
	@Column(name = "building_area", nullable = false, scale = 2)
	private BigDecimal buildingArea;
	/**
	 * 使用面积
	 */
	@Column(name = "usable_area", nullable = false, scale = 2)
	private BigDecimal usableArea;
	/**
	 * 室
	 */
	@Column(nullable = false)
	private Byte bedroomCount;
	/**
	 * 厅
	 */
	@Column(nullable = false)
	private Byte livingRoomCount;
	/**
	 * 厨
	 */
	@Column(nullable = false)
	private Byte kitchenCount;
	/**
	 * 卫
	 */
	@Column(nullable = false)
	private Byte washroomCount;
	/**
	 * 阳台
	 */
	@Column(nullable = false)
	private Byte balconyCount;
	/**
	 * 建筑年代（对应数据配置表类型2）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "construction_year_id")
	private Data constructionYear;
	/**
	 * 总楼层
	 */
	@Column(name = "total_floor", nullable = false)
	private Byte totalFloor;
	/**
	 * 所在楼层
	 */
	@Column(nullable = false)
	private Byte floor;

	/*
	 * 以下为选填信息
	 */

	/**
	 * 朝向（对应数据配置表类型0）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orientation_id")
	private Data orientation;
	/**
	 * 物业类型（对应数据配置表类型1）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "property_type_id")
	private Data propertyType;
	/**
	 * 装修程度（对应数据配置表类型3）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "decoration_id")
	private Data decoration;
	/**
	 * 产权性质（对应数据配置表类型6）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "property_right_id")
	private Data propertyRight;
	/**
	 * 住宅类别（对应数据配置表类型7）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "residence_type_id")
	private Data residenceType;
	/**
	 * 建筑类别（对应数据配置表类型8）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "construction_type_id")
	private Data constructionType;
	/**
	 * 房屋结构（对应数据配置表类型9）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "building_structure_id")
	private Data buildingStructure;
	/**
	 * 看房时间（对应数据配置表类型10）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_time_id")
	private Data visitTime;
	/**
	 * 交通状况
	 */
	@Column(length = 500)
	private String transport;
	/**
	 * 周边配套
	 */
	@Column(length = 500)
	private String environment;
	/**
	 * 房源描述
	 */
	@Column(length = 500)
	private String remark;
	/**
	 * 配套设施
	 */
	@ManyToMany(targetEntity = Data.class, fetch = FetchType.LAZY)
	@JoinTable(name = "rlt_shh_to_facility", joinColumns = @JoinColumn(name = "shh_id"), inverseJoinColumns = @JoinColumn(name = "data_id"))
	private List<Data> facilities = new ArrayList<Data>();
	/**
	 * 房源特色
	 */
	@ManyToMany(targetEntity = Data.class, fetch = FetchType.LAZY)
	@JoinTable(name = "rlt_shh_to_feature", joinColumns = @JoinColumn(name = "shh_id"), inverseJoinColumns = @JoinColumn(name = "data_id"))
	private List<Data> features = new ArrayList<Data>();
	/**
	 * 有效期
	 */
	// @Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date expiration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Area getProvince() {
		return province;
	}

	public void setProvince(Area province) {
		this.province = province;
	}

	public Area getCity() {
		return city;
	}

	public void setCity(Area city) {
		this.city = city;
	}

	public Area getDistrict() {
		return district;
	}

	public void setDistrict(Area district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(BigDecimal buildingArea) {
		this.buildingArea = buildingArea;
	}

	public BigDecimal getUsableArea() {
		return usableArea;
	}

	public void setUsableArea(BigDecimal usableArea) {
		this.usableArea = usableArea;
	}

	public Byte getBedroomCount() {
		return bedroomCount;
	}

	public void setBedroomCount(Byte bedroomCount) {
		this.bedroomCount = bedroomCount;
	}

	public Byte getLivingRoomCount() {
		return livingRoomCount;
	}

	public void setLivingRoomCount(Byte livingRoomCount) {
		this.livingRoomCount = livingRoomCount;
	}

	public Byte getKitchenCount() {
		return kitchenCount;
	}

	public void setKitchenCount(Byte kitchenCount) {
		this.kitchenCount = kitchenCount;
	}

	public Byte getWashroomCount() {
		return washroomCount;
	}

	public void setWashroomCount(Byte washroomCount) {
		this.washroomCount = washroomCount;
	}

	public Byte getBalconyCount() {
		return balconyCount;
	}

	public void setBalconyCount(Byte balconyCount) {
		this.balconyCount = balconyCount;
	}

	public Data getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear(Data constructionYear) {
		this.constructionYear = constructionYear;
	}

	public Byte getTotalFloor() {
		return totalFloor;
	}

	public void setTotalFloor(Byte totalFloor) {
		this.totalFloor = totalFloor;
	}

	public Byte getFloor() {
		return floor;
	}

	public void setFloor(Byte floor) {
		this.floor = floor;
	}

	public Data getOrientation() {
		return orientation;
	}

	public void setOrientation(Data orientation) {
		this.orientation = orientation;
	}

	public Data getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(Data propertyType) {
		this.propertyType = propertyType;
	}

	public Data getDecoration() {
		return decoration;
	}

	public void setDecoration(Data decoration) {
		this.decoration = decoration;
	}

	public Data getPropertyRight() {
		return propertyRight;
	}

	public void setPropertyRight(Data propertyRight) {
		this.propertyRight = propertyRight;
	}

	public Data getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(Data residenceType) {
		this.residenceType = residenceType;
	}

	public Data getConstructionType() {
		return constructionType;
	}

	public void setConstructionType(Data constructionType) {
		this.constructionType = constructionType;
	}

	public Data getBuildingStructure() {
		return buildingStructure;
	}

	public void setBuildingStructure(Data buildingStructure) {
		this.buildingStructure = buildingStructure;
	}

	public Data getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Data visitTime) {
		this.visitTime = visitTime;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<Data> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<Data> facilities) {
		this.facilities = facilities;
	}

	public List<Data> getFeatures() {
		return features;
	}

	public void setFeatures(List<Data> features) {
		this.features = features;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

}
