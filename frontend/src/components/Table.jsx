// Table.js
import React, { useState } from "react";

export function renderTableFromJson(jsonData, options = {}) {
  const { columns = [], hiddenColumns = [], rowsPerPage = 5 } = options;
  const visibleColumns = columns.filter(
    (col) => !hiddenColumns.includes(col.accessor)
  );

  return <Table columns={visibleColumns} data={jsonData} rowsPerPage={rowsPerPage} />;
}

function Table({ columns, data, rowsPerPage = 5 }) {
  const [currentPage, setCurrentPage] = useState(1);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortConfig, setSortConfig] = useState({ key: null, direction: "asc" });

  // 🔍 Search filter
  const filteredData = data.filter((row) =>
    columns.some((col) =>
      String(row[col.accessor])
        .toLowerCase()
        .includes(searchTerm.toLowerCase())
    )
  );

  // 🔽 Sorting
  const sortedData = [...filteredData].sort((a, b) => {
    if (!sortConfig.key) return 0;
    const valA = a[sortConfig.key];
    const valB = b[sortConfig.key];
    if (valA < valB) return sortConfig.direction === "asc" ? -1 : 1;
    if (valA > valB) return sortConfig.direction === "asc" ? 1 : -1;
    return 0;
  });

  // 📄 Pagination
  const totalPages = Math.ceil(sortedData.length / rowsPerPage);
  const startIndex = (currentPage - 1) * rowsPerPage;
  const currentData = sortedData.slice(startIndex, startIndex + rowsPerPage);

  // 🔄 Handle sorting toggle
  const handleSort = (key) => {
    let direction = "asc";
    if (sortConfig.key === key && sortConfig.direction === "asc") {
      direction = "desc";
    }
    setSortConfig({ key, direction });
  };

  return (
    <div className="overflow-x-auto">
      {/* Search box */}
      <div className="mb-4">
        <input
          type="text"
          placeholder="Search..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="px-4 py-2 border rounded-xl w-full focus:outline-none focus:ring focus:border-indigo-500"
        />
      </div>

      {/* Table */}
      <table className="min-w-full bg-white border border-gray-200 rounded-lg shadow-sm">
        <thead>
          <tr className="bg-blue">
            {columns.map((col, index) => (
              <th
                key={index}
                onClick={() => handleSort(col.accessor)}
                className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider cursor-pointer"
              >
                {col.header}
                {sortConfig.key === col.accessor &&
                  (sortConfig.direction === "asc" ? " ▲" : " ▼")}
              </th>
            ))}
          </tr>
        </thead>
        <tbody>
          {currentData.map((row, rowIndex) => (
            <tr key={rowIndex} className="hover:bg-gray-100 transition-colors">
              {columns.map((col, colIndex) => (
                <td
                  key={colIndex}
                  className="px-6 py-4 text-sm text-gray-700 border-b border-gray-200"
                >
                  {row[col.accessor]}
                </td>
              ))}
            </tr>
          ))}
        </tbody>
      </table>

      {/* Pagination Controls */}
      <div className="flex justify-between items-center mt-4">
        <button
          disabled={currentPage === 1}
          onClick={() => setCurrentPage((p) => p - 1)}
          className="px-3 py-1 bg-gray-200 rounded disabled:opacity-50"
        >
          Previous
        </button>
        <span className="text-sm text-gray-600">
          Page {currentPage} of {totalPages}
        </span>
        <button
          disabled={currentPage === totalPages}
          onClick={() => setCurrentPage((p) => p + 1)}
          className="px-3 py-1 bg-gray-200 rounded disabled:opacity-50"
        >
          Next
        </button>
      </div>
    </div>
  );
}

export default Table;
