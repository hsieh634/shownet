# Catalog Specification

## Requirements

### Requirement: Public product search
系統 SHALL 提供公開商品查詢端點，且只回傳 active 商品。

#### Scenario: filter by type and destination
- **WHEN** 用戶以 `type` 與 `destinationCode` 查詢
- **THEN** 系統回傳同時符合兩個條件的商品清單

### Requirement: Consistent product model
系統 SHALL 將商品類型限制為 HOTEL、VILLA、TRANSFER、DAY_TOUR、MULTI_DAY_TOUR、DIVING、CRUISE。

#### Scenario: unsupported type
- **WHEN** 寫入不支援的商品類型
- **THEN** 資料庫拒絕該資料
