# API整理

## 展会管理

### 展会拓扑可视化监控 && 展位用电数据监控

1. /icbms/projectinfo/getCurrentProject
    1. response:  class Result

    ```java
    class result {
        private String code;
        private String msg;
        private List<LocationInfoEntity> locInfos;
    }

    class LocationInfoEntity {
        // id主键
        private String id;
        // 项目号
        private String projectId;
        // 父菜单id
        private String parentId;
        // 位置名称
        private String name;
        // 位置图标
        private String icon;
        // 排序
        private Integer sort;
        // 状态（0显示，-1隐藏)
        private String status;
        // 备注
        private String remark;
        // 位置类型
        private String type;
        // 父位置名字
        private String parentName;
        // 子类位置
        private List list;
        // 是否展开
        private String open;;
        // 对应的电箱
        private List<DeviceBoxInfoEntity> dboxList = new ArrayList<DeviceBoxInfoEntity>();
        // 是否含有紧急告警状态
        private String hasAlarm = "0";

        // 根路径
        private String root;

        // 文件名称
        private String fileName;

        // 在线状态
        private String online;
    }

    class DeviceBoxInfoEntity {
        @ApiModelProperty(value = "电箱ID", name = "id", required = true)
        private String id;
        @ApiModelProperty(value = "项目ID", name = "projectId", required = true)
        private String projectId;

        @ApiModelProperty(value = "位置集合", name = "locationList", required = false)
        private List<LocationInfoEntity> locationList = new ArrayList<LocationInfoEntity>();
        @ApiModelProperty(value = "位置ID", name = "locationId")
        private String locationId;
        @ApiModelProperty(value = "位置名称", name = "locationName")
        private String locationName;
        // 电箱ID集合
        private String[] deviceIds;
        @ApiModelProperty(value = "项目名称", name = "projectName")
        private String projectName;
        @ApiModelProperty(value = "电箱MAC地址", name = "deviceBoxNum")
        private String deviceBoxNum;
        @ApiModelProperty(value = "电箱密码", name = "deviceBoxPass")
        private String deviceBoxPass;
        @ApiModelProperty(value = "电箱名称", name = "deviceBoxName")
        private String deviceBoxName;
        // 新建时间
        private Date createTime;
        // 更新时间
        private Date updateTime;
        // 创建者
        private String createId;
        // 更新者
        private String updateId;
        @ApiModelProperty(value = "备注", name = "remark")
        private String remark;
        @ApiModelProperty(value = "是否在线[0:是,1:否]", name = "online")
        private String online = "1";
        @ApiModelProperty(value = "横坐标", name = "fx")
        private String fx;
        @ApiModelProperty(value = "纵坐标", name = "fy")
        private String fy;
        @ApiModelProperty(value = "二级电箱网关号", name = "secBoxGateway")
        private String secBoxGateway;
        @ApiModelProperty(value = "展位号", name = "standNo")
        private String standNo;
        @ApiModelProperty(value = "是否受控[0:否 1:是]", name = "controlFlag")
        private String controlFlag;

        @ApiModelProperty(value = "电箱容量", name = "boxCapacity")
        private String boxCapacity;

        // 空开信息
        private List<DeviceSwitchInfoEntity> switchList;

        // 告警信息
        private DeviceAlarmInfoLogEntity alarm;

        // 所有告警信息
        private List<DeviceAlarmInfoLogEntity> allAlarm;

        // 控制名称
        private String controlFlagName;

        // 告警ID
        private String alarmLogId;

        // 电箱是否在用 0:空闲 1:在用
        @ApiModelProperty(value = "电箱是否在用[0:空闲,1:在用]", name = "boxStatus")
        private String boxStatus;

        @ApiModelProperty(value = "收电箱标记[0/null:未收,1:已收]", name = "placedFlag")
        private String placedFlag;

        // 配置信息
        private DeviceBoxConfigEntity config;

        /**
        * 新增人
        */
        private String createId;
        /**
        * 修改者
        */
        private String updateId;
        /**
        * 备注
        */
        private String remark;
        /**
        * 新增时间
        */
        private Date createTime;
        /**
        * 更新时间
        */
        private Date updateTime;

        /**
        * 部门(组织)ID【FK】,直接归属的组织ID
        */
        private String baid;
        /**
        * 机构ID【FK】(上级)
        */
        private String bapid;

        /**
        * 部门ids 部门数据权限
        */
        private List<String> baidList;
        /**
        * 机构ids 机构数据权限
        */
        private List<String> bapidList;

        /**
        * 部门名称
        */
        private String baName;

        /**
        * 机构名称
        */
        private String bapName;
    }
    ```

2. /icbms/app/dashbaord/findLocInfoByPId?projectId={id}
    1. response: List<LocationInfoEntity>(同上)

### 设备状态查看

1. /icbms/deviceboxinfo/deviceView?_search=false&nd=1606984266281&limit=10&page=1&sidx=&order=asc&_=1606984264765
    1. request: {_search: false,nd: 1606983375505,limit: 10,page: 1,sidx: ,order: asc,_: 1606983374390,gatewayMac: "",deviceBoxMac: das}
    2. response: response 如下

    ```java
    class Result {
        private String code;
        private String msg;
        private PageUtils page;
    }
    class PageUtils {
        // 总记录数
        private int totalCount;
        // 每页记录数
        private int pageSize;
        // 总页数
        private int totalPage;
        // 当前页数
        private int currPage;
        // 列表数据
        private List<DeviceBoxInfoEntity> list;
    }
    class DeviceBoxInfoEntity {
        @ApiModelProperty(value = "电箱ID", name = "id", required = true)
        private String id;
        @ApiModelProperty(value = "项目ID", name = "projectId", required = true)
        private String projectId;

        @ApiModelProperty(value = "位置集合", name = "locationList", required = false)
        private List<LocationInfoEntity> locationList = new ArrayList<LocationInfoEntity>();
        @ApiModelProperty(value = "位置ID", name = "locationId")
        private String locationId;
        @ApiModelProperty(value = "位置名称", name = "locationName")
        private String locationName;
        // 电箱ID集合
        private String[] deviceIds;
        @ApiModelProperty(value = "项目名称", name = "projectName")
        private String projectName;
        @ApiModelProperty(value = "电箱MAC地址", name = "deviceBoxNum")
        private String deviceBoxNum;
        @ApiModelProperty(value = "电箱密码", name = "deviceBoxPass")
        private String deviceBoxPass;
        @ApiModelProperty(value = "电箱名称", name = "deviceBoxName")
        private String deviceBoxName;
        // 新建时间
        private Date createTime;
        // 更新时间
        private Date updateTime;
        // 创建者
        private String createId;
        // 更新者
        private String updateId;
        @ApiModelProperty(value = "备注", name = "remark")
        private String remark;
        @ApiModelProperty(value = "是否在线[0:是,1:否]", name = "online")
        private String online = "1";
        @ApiModelProperty(value = "横坐标", name = "fx")
        private String fx;
        @ApiModelProperty(value = "纵坐标", name = "fy")
        private String fy;
        @ApiModelProperty(value = "二级电箱网关号", name = "secBoxGateway")
        private String secBoxGateway;
        @ApiModelProperty(value = "展位号", name = "standNo")
        private String standNo;
        @ApiModelProperty(value = "是否受控[0:否 1:是]", name = "controlFlag")
        private String controlFlag;

        @ApiModelProperty(value = "电箱容量", name = "boxCapacity")
        private String boxCapacity;

        // 空开信息
        private List<DeviceSwitchInfoEntity> switchList;

        // 告警信息
        private DeviceAlarmInfoLogEntity alarm;

        // 所有告警信息
        private List<DeviceAlarmInfoLogEntity> allAlarm;

        // 控制名称
        private String controlFlagName;

        // 告警ID
        private String alarmLogId;

        // 电箱是否在用 0:空闲 1:在用
        @ApiModelProperty(value = "电箱是否在用[0:空闲,1:在用]", name = "boxStatus")
        private String boxStatus;

        @ApiModelProperty(value = "收电箱标记[0/null:未收,1:已收]", name = "placedFlag")
        private String placedFlag;

        // 配置信息
        private DeviceBoxConfigEntity config;
    }
    ```

### 展会拓扑图配置

### 展位用电量需求配置表

1. /icbms/deviceboxinfo/list?_search=false&nd=1606986230994&limit=10&page=1&sidx=&order=asc&locationId=&deviceBoxNum=121&secBoxGateway=11&standNo=11&_=1606986120252
    1. request: {_search: false,nd: 1606983375505,limit: 10,page: 1,sidx: , order: asc,locationId: , deviceBoxNum: 121, secBoxGateway: 11, standNo: 11, _: 1606983374390}
    2. response: 如下

    ```java
    class Result {
        private String code;
        private String msg;
        private PageUtils page;
    }
    class PageUtils {
        // 总记录数
        private int totalCount;
        // 每页记录数
        private int pageSize;
        // 总页数
        private int totalPage;
        // 当前页数
        private int currPage;
        // 列表数据
        private List<DeviceBoxInfoEntity> list;
    }
    ```

2. /icbms/deviceboxinfo/info/{id}
    1. response : class DeviceBoxInfoEntity;
3. /icbms/deviceboxinfo/save
   1. request: class DeviceBoxInfoEntity
   2. response: {code: string,msg:string}
4. /icbms/deviceboxinfo/update
   1. request: class DeviceBoxInfoEntity
   2. response: {code: string,msg:string}
5. /icbms/deviceboxinfo/delete
   1. request: Array<String> ids;
   2. response: {code: string,msg:string}
6. /icbms/deviceboxinfo/findDeviceBoxsInfoByLId
   1. request: String locationId;
   2. response: 如下;

    ```java
    class Result {
        private String code;
        private String msg;
        private List<DeviceBoxInfoEntity> deviceBoxs;
    }
    ```

7. /icbms/deviceboxinfo/findMapDeviceBoxsInfo
   1. request: String locationId, String showBoxOnline;
   2. response: 如下;

   ```java
    class Result {
        private String code;
        private String msg;
        private List<DeviceBoxInfoEntity> deviceBoxs;
    }
    ```

8. /icbms/deviceboxinfo/setDeboxInfoXy
   1. request: String deviceBoxInfoId, String fx, String fy;
   2. response: 如下;

    ```java
    class Result {
        private String code;
        private String msg;
        private DeviceBoxInfoEntity deviceBoxInfo;
    }
    ```

9. /icbms/deviceboxinfo/resetXy
   1. request: String deviceBoxInfoId, String fx, String fy;
   2. response: 如下;

    ```java
    class Result {
        private String code;
        private String msg;
        private DeviceBoxInfoEntity deviceBoxInfo;
    }
    ```

10. /icbms/deviceboxinfo/batchImpDevices
    1. request: MultipartFile file （上传文件）;
    2. response: List<Map<String, String>>, 其中Map结构如下;

    ```java
    {
        private String firstLoc;
        private String secLoc;
        private String thirdLoc;
        private String forthLoc;
        private String fifthLoc;
        private String deviceMac;
        private String remark;
        private String secBoxGateway;
        private String standNo;
        private String boxCapacity;
        private String controlFlag;
    }
    ```

### 设备出厂配置表

### 展位配置管理

1. /icbms/locationinfo/initTreeData?_=1606984569849
    1. response: 如下

    ```java
    class Result {
        private String code;
        private String msg;
        private List<LocationInfoEntity> locationList;
    }
    ```

2. /icbms/locationinfo/save
    1. request: LocationInfoEntity location;
    2. response: 如下;

    ```java
    class Result {
        private String code;
        private String msg;
        private LocationInfoEntity locationinfo;
    }
    ```

3. /icbms/locationinfo/update
    1. request: LocationInfoEntity location;
    2. response: 如下;

    ```java
    class Result {
        private String code;
        private String msg;
        private LocationInfoEntity locationinfo;
    }
    ```

4. /icbms/locationinfo/delete
    1. request: String ids (多个id以 , 分割);
    2. response: {code: string, msg: string} ;
5. /icbms/locationinfo/findLocInfoByPId
    1. request: String projectId;
    2. response: 如下;

    ```java
     class Result {
        private String code;
        private String msg;
        private List<LocationInfoEntity> locInfos;
    }
    ```

6. /icbms/locationinfo/upload
    1. request: MultipartFile file,上传图片;
    2. response: 如下;

     ```java
    class Result {
        private String code;
        private String msg;
        private String pictureName;
    }
    ```

7. /icbms/locationinfo/viewImg/{fileName:.+}
    1. request: String fileName;
    2. response: file byte.

## 项目管理

### 项目配置

1. /icbms/projectinfo/list?_search=false&nd=1606983375505&limit=10&page=1&sidx=&order=asc&_=1606983374390
    1. request: {_search: false,nd: 1606983375505,limit: 10,page: 1,sidx: ,order: asc,_: 1606983374390}
    2. response: response 如下

    ```java
    class Result {
        private String code;
        private String msg;
        private PageUtils page;
    }

    class PageUtils {
        // 总记录数
        private int totalCount;
        // 每页记录数
        private int pageSize;
        // 总页数
        private int totalPage;
        // 当前页数
        private int currPage;
        // 列表数据
        private List<ProjectInfoEntity> list;
    }
    class ProjectInfoEntity {
        // id主键
        private String id;
        // 项目名称
        private String projectName;
        // 新建时间
        private Date createTime;
        // 更新时间
        private Date updateTime;
        // 创建者
        private String createId;
        // 更新者
        private String updateId;
        // 备注
        private String remark;

        private String createTimeStr;

        // 生效日期
        private String effectiveDate;

        // 失效日期
        private String expireDate;

        // 网关
        private String gatewayAddress;

        /**
        * 角色ID列表
        */
        private List<String> roleIdList;
    }
    ```

2. /icbms/projectinfo/info/{id}
    1. request: String id;
    2. response: 如下。

    ```java
    class Result {
        private String code;
        private String msg;
        private ProjectInfoEntity projectInfo;
    }
    ```

3. /icbms/projectinfo/save
    1. request: ProjectInfoEntity projectInfo;
    2. response: {code: string,msg:string}。
4. /icbms/projectinfo/update
    1. request: ProjectInfoEntity projectInfo;
    2. response: {code: string,msg:string}。
5. /icbms/projectinfo/delete
    1. request: Array<String> ids;
    2. response: {code: string,msg:string}。
6. /icbms/projectinfo/listAll
    1. response: 如下。

    ```java
    class Result {
        private String code;
        private String msg;
        private List<ProjectInfoEntity> projectInfoList;
    }
    ```

7. /icbms/projectinfo/getCurrentProject
    1. response: 如下。

    ```java
    class Result {
        private String code;
        private String msg;
        private ProjectInfoEntity currentProject;
        private List<LocationInfoEntity> locInfos;
    }
    ```

## 报表管理

### 告警报表

1. /icbms/report/alarm/list?_search=false&nd=1606984871663&limit=10&page=1&sidx=&order=asc&beginTime=2020-12-24&endTime=2021-01-01&_=1606985083979
    1. requse: {_search: false,nd: 1606983375505,limit: 10,page: 1,sidx: ,order: asc,_: 1606983374390, beginTime: 2020-12-24,endTime: 2021-01-01}
    2. response: 如下

    ```java
    class Result {
        private String code;
        private String msg;
        private PageUtils page;
    }
    class PageUtils {
        // 总记录数
        private int totalCount;
        // 每页记录数
        private int pageSize;
        // 总页数
        private int totalPage;
        // 当前页数
        private int currPage;
        // 列表数据
        private List<AlarmInfoReportEntity> list;
    }
    class AlarmInfoReportEntity {
        //id主键
        private String id;
        //
        private String projectId;
        //电箱MAC地址
        private String deviceBoxMac;
        //
        private String deviceBoxId;
        //记录ID
        private Integer autoId;
        //线路名称
        private String node;
        //
        private String type;
        //告警时间
        private Date recordTime;
        //告警信息内容
        private String info;
        //告警状态 1告警 0恢复
        private String alarmStatus;
        //新建时间
        private Date createTime;
        //更新时间
        private Date updateTime;
        //创建者
        private String createId;
        //更新者
        private String updateId;
        //备注
        private String remark;
        //告警等级
        private String alarmLevel;
        //告警等级名称
        private String alarmLevelName;
        private String standNo;
    }
    ```

2. /icbms/report/alarm/exportAll
    1. request: String beginTime, String endTime;
    2. response: 导出Excel文件

### 电量报表

1. /icbms/report/electric/list?_search=false&nd=1606985084311&limit=10&page=1&sidx=&order=asc&beginTime=2020-12-24&endTime=2021-01-01&_=1606985083979
    1. request: {_search: false,nd: 1606983375505,limit: 10,page: 1,sidx: ,order: asc,_: 1606983374390, beginTime: 2020-12-24,endTime: 2021-01-01}
    2. response: 如下

    ```java
    class Result {
        private String code;
        private String msg;
        private PageUtils page;
    }
    class PageUtils {
        // 总记录数
        private int totalCount;
        // 每页记录数
        private int pageSize;
        // 总页数
        private int totalPage;
        // 当前页数
        private int currPage;
        // 列表数据
        private List<ElectricReportEntity> list;
    }
    class ElectricReportEntity {
        private String projectId;
        private String deviceBoxId;
        private String standNo;
        private String secBoxGateway;
        private String statDate;
        private String deviceBoxNum;
        private String addr;
        private String electricity;
    }
    ```

2. /icbms/report/electric/exportAll
    1. request: String beginTime, String endTime;
    2. response: 导出Excel文件

### 当日用电监控

1. /icbms/report/electricdaily/list?_search=false&nd=1606989407924&limit=50&page=1&sidx=&order=asc&deviceBoxNum=1&secBoxGateway=1&standNo=1&_=1606989382630
    1. requset: {_search: false,nd: 1606983375505,limit: 10,page: 1,sidx: ,order: asc,_: 1606983374390, deviceBoxNum: 1,secBoxGateway: 1,standNo: 1}
    2. response: 如下。

    ```java
    class Result {
        private String code;
        private String msg;
        private PageUtils page;
    }
    class PageUtils {
        // 总记录数
        private int totalCount;
        // 每页记录数
        private int pageSize;
        // 总页数
        private int totalPage;
        // 当前页数
        private int currPage;
        // 列表数据
        private List<ElectricDailyEntity> list;
    }
    class ElectricDailyEntity {
        private String projectId;
        private String deviceBoxId;
        private String standNo;
        private String secBoxGateway;
        private String statDate;
        private String deviceBoxNum;
        private String addr;
        private String electricity;
    }
    ```
